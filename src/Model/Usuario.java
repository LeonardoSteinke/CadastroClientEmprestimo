/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Leonardo Steinke
 */
public class Usuario {

    String Nome;
    String Email;
    String CPF;
    String CEP;
    String Rua;
    String Bairro;
    String Cidade;
    Double Salario;
    Double Emprestimo;
    int Parcelas;

    public Usuario() {
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public Double getEmprestimo() {
        return Emprestimo;
    }

    public void setEmprestimo(Double Emprestimo) {
        this.Emprestimo = Emprestimo;
    }

    public int getParcelas() {
        return Parcelas;
    }

    public void setParcelas(int Parcelas) {
        this.Parcelas = Parcelas;
    }

    
  

}
