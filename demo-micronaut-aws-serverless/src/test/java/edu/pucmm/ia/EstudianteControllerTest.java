package edu.pucmm.ia;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pucmm.ia.encapsulaciones.EstudianteRequest;
import edu.pucmm.ia.encapsulaciones.EstudianteResponse;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.micronaut.function.aws.proxy.MicronautLambdaHandler;

public class EstudianteControllerTest {

    private static MicronautLambdaHandler handler;
    private static Context lambdaContext = new MockLambdaContext();
    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setupSpec() {
        try {
            handler = new MicronautLambdaHandler();
            objectMapper = handler.getApplicationContext().getBean(ObjectMapper.class);

        } catch (ContainerInitializationException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void cleanupSpec() {
        handler.getApplicationContext().close();
    }

    @Test
    void testSaveEstudiante() throws JsonProcessingException {
        EstudianteRequest estudiante = new EstudianteRequest();
        estudiante.setMatricula(1);
        estudiante.setNombre("Carlos Camacho");
        estudiante.setCarrera("ITT");
        String json = objectMapper.writeValueAsString(estudiante);
        AwsProxyRequest request = new AwsProxyRequestBuilder("/", HttpMethod.POST.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(json)
                .build();
        AwsProxyResponse response = handler.handleRequest(request, lambdaContext);
        Assertions.assertEquals(HttpStatus.OK.getCode(), response.getStatusCode());
        EstudianteResponse estudianteResponse = objectMapper.readValue(response.getBody(), EstudianteResponse.class);
        Assertions.assertEquals(estudianteResponse.getNombre(), estudiante.getNombre());
    }
}
