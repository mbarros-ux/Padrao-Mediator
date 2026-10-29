package padroescomportamentais.mediator;

public class HubDeSeguranca implements Mediator {

    private SensorMovimento sensor;
    private Camera camera;
    private Alarme alarme;

    public void setSensor(SensorMovimento sensor) {
        this.sensor = sensor;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setAlarme(Alarme alarme) {
        this.alarme = alarme;
    }

    @Override
    public void notificar(ColegaSeguranca remetente, String evento) {
        if (evento.equals("INTRUSAO")) {
            System.out.println("[Hub] Recebido alerta de intrusão. Ativando protocolos de emergência...");
            camera.iniciarGravacao();
            alarme.dispararSirene();
        } else if (evento.equals("FALSO_POSITIVO")) {
            System.out.println("[Hub] Cancelando alerta. Normalizando sistema...");
            camera.pararGravacao();
            alarme.desativarSirene();
        }
    }
}