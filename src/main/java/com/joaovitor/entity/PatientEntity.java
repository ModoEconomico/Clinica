package com.joaovitor.entity;


public class PatientEntity extends UserEntity{
    private static int contador = 1;
    private int id;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private String planoSaude;

    public PatientEntity(String nome, String dataNascimento, String cpf, String telefone, String email, String planoSaude) {
        this.id = contador++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.planoSaude = planoSaude;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }
    public void setPlanoSaude(String planoSaude) { this.planoSaude = planoSaude; }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
