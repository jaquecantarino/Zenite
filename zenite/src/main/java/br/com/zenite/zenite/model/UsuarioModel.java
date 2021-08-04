package br.com.zenite.zenite.model;

import java.net.PasswordAuthentication;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min=2 ,max=60 )
	private String nome;
	
	@NotBlank
	@Size(min=2 ,max=80)
	private String email;
	
	@NotBlank
	@Size (min=6, max= 18)
	private PasswordAuthentication senha;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private List<PostagemModel> postagem;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PasswordAuthentication getSenha() {
		return senha;
	}

	public void setSenha(PasswordAuthentication senha) {
		this.senha = senha;
	}
	
	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

	

}