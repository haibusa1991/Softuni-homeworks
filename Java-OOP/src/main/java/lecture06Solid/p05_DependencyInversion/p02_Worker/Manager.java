package lecture06Solid.p05_DependencyInversion.p02_Worker;

public class Manager {

    public Manager() {
        Worker worker = new Worker();
        worker.work();
    }
}
