package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;
import interfaces.DbContext;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class EntityManager implements DbContext {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(Object entity) throws IllegalAccessException, SQLException {
        if (hasId(entity)) {
            return doUpdate(entity);
        }
        return doInsert(entity);

    }

    @Override
    public Iterable find(Class table) {
        return null;
    }

    @Override
    public Iterable find(Class table, String where) {
        return null;
    }

    @Override
    public Object findFirst(Class table) {
        return null;
    }

    @Override
    public Object findFirst(Class table, String where) {
        return null;
    }

    private Map<String, String> getIdColumnAndValue(Object entity) throws IllegalAccessException {
        Field id = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(e -> e.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Object doesn't have Id annotation"));

        id.setAccessible(true);
        String name = id.getName();
        String value = id.get(entity).toString();

        Map<String, String> values = new HashMap<>();

        if(Integer.parseInt(value)<=0){
            return values;
        }

        values.put(name, value);

        return values;
    }

    private String getTableName(Object entity) {
        String tableName = entity.getClass().getAnnotationsByType(Entity.class)[0].name();
        if (tableName == null) {
            throw new IllegalArgumentException("Object doesn't have Entity annotation");
        }

        return tableName;
    }

    private Map<String, String> getColumnsAndValues(Object entity) throws IllegalAccessException {
        Field[] columns = Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(e -> e.isAnnotationPresent(Column.class))
                .toArray(Field[]::new);

        Map<String, String> columnsAndValues = new HashMap<>();

        for (Field column : columns) {
            column.setAccessible(true);
            String columnName = column.getName();
            String columnValue = column.get(entity).toString();
            columnsAndValues.put(columnName, columnValue);
        }

        return columnsAndValues;
    }

    private boolean hasId(Object entity) throws IllegalAccessException {
        Iterator<Map.Entry<String, String>> idData = getIdColumnAndValue(entity).entrySet().iterator();
        return idData.hasNext();
    }

    private boolean doInsert(Object entity) throws SQLException, IllegalAccessException {
        String tableName = getTableName(entity);
        Map<String, String> values = getColumnsAndValues(entity);
        StringBuilder statement = new StringBuilder("INSERT INTO `");
        statement.append(tableName)
                .append("` (")
                .append(String.join(",", values.keySet()))
                .append(") VALUES (");

        List<String> quotedValues = new ArrayList<>();
        for (String value : values.values()) {
            quotedValues.add("'" + value + "'");
        }

        statement.append(String.join(",", quotedValues))
                .append(");");
        PreparedStatement ps = this.connection.prepareStatement(statement.toString());
        int result = ps.executeUpdate();

        return result == 1;
    }

    private boolean doUpdate(Object entity) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity);
        Map<String, String> values = getColumnsAndValues(entity);

        StringBuilder statement = new StringBuilder("UPDATE ");
        statement.append(tableName)
                .append(" SET ");

        List<String> updatedValues = new ArrayList<>();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            updatedValues.add("`" + entry.getKey() + "` = '" + entry.getValue() + "'");
        }


        Iterator<Map.Entry<String, String>> iterator = getIdColumnAndValue(entity).entrySet().iterator();
        Map.Entry<String, String> idData = iterator.next();

        String idColumn = idData.getKey();
        String idValue = idData.getValue();

        statement.append(String.join(",", updatedValues))
                .append(" WHERE `")
                .append(idColumn)
                .append("` = '")
                .append(idValue)
                .append("';");

        PreparedStatement ps = MyConnector.getInstance().getConnection().prepareStatement(statement.toString());
        int result = ps.executeUpdate();

        return result > 0;
    }
}
