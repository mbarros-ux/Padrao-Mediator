package padroescomportamentais.mediator;

public abstract class ColegaSeguranca {
    protected Mediator mediador;

    protected ColegaSeguranca(Mediator mediador) {
        this.mediador = mediador;
    }
}