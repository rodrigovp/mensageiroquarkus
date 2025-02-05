package br.com.rodnet;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mensagem")
public class MensagemResource {

    @Inject
    private MensagemRepository mensagemRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String mensagem() {
        return mensagemRepository.obterMensagem().toString();
    }
}
