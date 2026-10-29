package padroescomportamentais.mediator;

public class MainMediator {
    public static void main(String[] args) {
        HubDeSeguranca hub = new HubDeSeguranca();

        SensorMovimento sensor = new SensorMovimento(hub);
        Camera camera = new Camera(hub);
        Alarme alarme = new Alarme(hub);

        hub.setSensor(sensor);
        hub.setCamera(camera);
        hub.setAlarme(alarme);

        System.out.println("--- CENÁRIO 1: Intrusão Real ---");
        sensor.detectarIntrusao();

        System.out.println("\n--- CENÁRIO 2: Falso Positivo ---");
        sensor.detectarFalsoPositivo();
    }
}