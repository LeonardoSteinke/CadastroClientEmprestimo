package Controller;

import Model.Endereco;
import Service.CepService;
import java.util.List;
import java.util.ArrayList;
import Controller.Observer;
import Model.Usuario;
import Service.EmprestimoService;
import java.io.IOException;
import main.ValidaCPF;

/**
 *
 * @author Leonardo Steinke
 */
public class Controller {

    private Controller() {
    }

    public static Controller getInstance() {
        return ControllerHolder.INSTANCE;
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public void sendData(String nome, String email, String CPF, String CEP, String rua, String bairro, String cidade, String salario, String emprestimo, Object parcelas) throws IOException {

        if (!wsVerificaEmprestimo(Double.parseDouble(salario), Double.parseDouble(emprestimo), Integer.parseInt(parcelas.toString()))) {
            notifyErroEmprestimo();
            return;
        }
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setCPF(CPF);
        u.setCEP(CEP);
        u.setRua(rua);
        u.setBairro(bairro);
        u.setCidade(cidade);
        u.setSalario(Double.parseDouble(salario));
        u.setEmprestimo(Double.parseDouble(emprestimo));
        u.setParcelas(Integer.parseInt(parcelas.toString()));

        EmprestimoService service = new EmprestimoService();
        service.postEmprestimo(u);

    }

    public void getEndereco(String text) {
        try {
            text = text.replaceAll(" ", "");
            text = text.replaceAll("-", "");
            Endereco endereco = CepService.buscaEnderecoPelo(text);
            notifySetEndereco(endereco.getLogradouro(), endereco.getLocalidade(), endereco.getBairro());
        } catch (Exception e) {
        }

    }

    public void validaCPF(String cpf) {
        ValidaCPF validacpf = new ValidaCPF();
        try {
            cpf = validacpf.digitosValidos(cpf);
            if (!validacpf.valido(cpf) || cpf.length() < 11) {
                notifyCPFInvalido();
            }
        } catch (Exception e) {
            notifyCPFInvalido();
        }
    }

    private static boolean wsVerificaEmprestimo(double salario, double emprestimo, int parcelas) {
        services.WSVerificaEmprestimo_Service service = new services.WSVerificaEmprestimo_Service();
        services.WSVerificaEmprestimo port = service.getWSVerificaEmprestimoPort();
        return port.wsVerificaEmprestimo(salario, emprestimo, parcelas);
    }

    //Observer
    private List<Observer> observer = new ArrayList<>();

    public void attach(Observer obs) {
        this.observer.add(obs);
    }

    private void notifySetEndereco(String Rua, String Cidade, String Bairro) {
        for (Observer obs : observer) {
            obs.setEndereco(Rua, Cidade, Bairro);
        }
    }

    private void notifyCPFInvalido() {
        for (Observer obs : observer) {
            obs.CPFInvalido();
        }
    }

    private void notifyErroEmprestimo() {
        for (Observer obs : observer) {
            obs.EmprestimoInvalido();
        }
    }

}
