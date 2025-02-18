package com.joaovitor.config;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class SimpleHttpServer {
    private HttpServer server;

    public void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8080), 0);
        System.out.println(" Servidor iniciado na porta 8080...");

        server.createContext("/addPatient", new AddPatientHandler());
        server.createContext("/addDoctor", new AddDoctorHandler());
        server.createContext("/addAppointment", new AddAppointmentHandler());

        server.setExecutor(null);
        server.start();
    }

    public void stopServer() {
        if (server != null) {
            server.stop(0);
            System.out.println("Servidor parado.");
        }
    }
}

class AddPatientHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String response = "Paciente cadastrado com sucesso!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}

class AddDoctorHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String response = "Médico cadastrado com sucesso!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}

class AddAppointmentHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            String response = "Consulta cadastrada com sucesso!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1);
        }
    }
}
