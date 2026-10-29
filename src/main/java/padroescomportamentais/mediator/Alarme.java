package padroescomportamentais.mediator;

public class Alarme extends ColegaSeguranca {

    public Alarme(Mediator mediador) {
        super(mediador);
    }

    public void dispararSirene() {
        System.out.println("[Alarme] 🚨 SIRENE DISPARADA! 🚨");
    }

    public void desativarSirene() {
        System.out.println("[Alarme] Sirene desativada. Sistema em standby.");
    }
}