package lecture08UnitTesting.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    Sensor mockSensor = Mockito.mock(Sensor.class);
    Alarm alarm;

    private final double VALID_PRESSURE = 18.0;
    private final double LOW_PRESSURE = 10.0;
    private final double HIGH_PRESSURE = 25.0;

    @Before
    public void setUp() {
        alarm = new Alarm(mockSensor);
    }

    @Test
    public void testSensorValidPressure() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(VALID_PRESSURE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testSensorLowPressure() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testSensorHighPressure() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
