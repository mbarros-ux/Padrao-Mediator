package padroescomportamentais.mediator;

public class SensorMovimento extends ColegaSeguranca {

    public SensorMovimento(Mediator mediador) {
        super(mediador);
    }

    public void detectarIntrusao() {
        System.out.println("[Sensor] Movimento suspeito detectado!");
        mediador.notificar(this, "INTRUSAO");
    }

    public void detectarFalsoPositivo() {
        System.out.println("[Sensor] Movimento era um animal. Falso positivo.");
        mediador.notificar(this, "FALSO_POSITIVO");
    }
}