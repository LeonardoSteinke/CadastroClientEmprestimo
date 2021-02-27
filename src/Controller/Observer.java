/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author Leonardo Steinke
 */
public interface Observer {
    
    void setEndereco(String Rua, String Cidade, String Bairro);

    public void CPFInvalido();

    public void EmprestimoInvalido();

}
