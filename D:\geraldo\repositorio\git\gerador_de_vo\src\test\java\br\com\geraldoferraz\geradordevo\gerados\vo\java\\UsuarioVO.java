import java.util.Calendar;
import java.util.List;
import br.com.geraldoferraz.geradordevo.entidades.PermissaoVO;
import br.com.geraldoferraz.geradordevo.entidades.TicketVO;
import #tipo;

public interface UsuarioVO extends {

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public Integer getIdade(){
		return this.idade;
	}

	public void setIdade(Integer idade){
		this.idade = idade;
	}

	public Calendar getNascimento(){
		return this.nascimento;
	}

	public void setNascimento(Calendar nascimento){
		this.nascimento = nascimento;
	}

	public List<PermissaoVO> getPermissoes(){
		return this.permissoes;
	}

	public void setPermissoes(List<PermissaoVO> permissoes){
		this.permissoes = permissoes;
	}

	public TicketVO getTicket(){
		return this.ticket;
	}

	public void setTicket(TicketVO ticket){
		this.ticket = ticket;
	}

}