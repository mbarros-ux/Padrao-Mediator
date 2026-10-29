package padroescomportamentais.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HubDeSegurancaTest {

    private HubDeSeguranca hub;
    private SensorMovimento sensor;
    private Camera camera;
    private Alarme alarme;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        hub = new HubDeSeguranca();
        sensor = new SensorMovimento(hub);
        camera = new Camera(hub);
        alarme = new Alarme(hub);

        hub.setSensor(sensor);
        hub.setCamera(camera);
        hub.setAlarme(alarme);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void deveCoordenarCameraEAlarmeAoDetectarIntrusao() {
        sensor.detectarIntrusao();
        String output = outContent.toString();

        assertTrue(output.contains("[Hub] Recebido alerta de intrusão"));
        assertTrue(output.contains("[Camera] Iniciando gravação"));
        assertTrue(output.contains("[Alarme] 🚨 SIRENE DISPARADA! 🚨"));
    }

    @Test
    public void deveDesativarSistemaAoDetectarFalsoPositivo() {
        sensor.detectarIntrusao();
        outContent.reset();

        sensor.detectarFalsoPositivo();
        String output = outContent.toString();

        assertTrue(output.contains("[Hub] Cancelando alerta"));
        assertTrue(output.contains("[Camera] Parando gravação"));
        assertTrue(output.contains("[Alarme] Sirene desativada"));
    }

    @Test
    public void deveManterBaixoAcoplamentoEntreColegas() {
        assertTrue(SensorMovimento.class.getDeclaredFields().length == 0,
                "SensorMovimento não deve ter campos próprios para manter baixo acoplamento");

        assertTrue(Camera.class.getDeclaredFields().length == 0,
                "Camera não deve ter campos próprios para manter baixo acoplamento");

        assertTrue(Alarme.class.getDeclaredFields().length == 0,
                "Alarme não deve ter campos próprios para manter baixo acoplamento");
    }
}