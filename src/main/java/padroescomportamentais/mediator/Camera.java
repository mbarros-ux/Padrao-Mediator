package padroescomportamentais.mediator;

public class Camera extends ColegaSeguranca {

    public Camera(Mediator mediador) {
        super(mediador);
    }

    public void iniciarGravacao() {
        System.out.println("[Camera] Iniciando gravação em 4K com timestamp...");
    }

    public void pararGravacao() {
        System.out.println("[Camera] Parando gravação e salvando buffer.");
    }
}