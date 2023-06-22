package br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Documentacao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.SimNao;
import br.gov.pa.ideflorbio.dadoseconomicossociais.domain.model.enums.Situacao_Fundiaria;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Getter
@Setter
public class Imovel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private Long id;
	
	private String rua;
	
	private String numero;
	
	private String bairro;
	
	@NotBlank
	private String referencial;
	
	@NotBlank
	private String latitude;
	
	@NotBlank
	private String longitude;
	
	@Enumerated(EnumType.STRING)
	private Situacao_Fundiaria situacaoFundiaria;
	
	@NotNull
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private Date dataChegada;
	
	
	//@Enumerated(EnumType.STRING)
	//private LimitesImovel limites;
	
	
	@Enumerated(EnumType.STRING)
	private Documentacao documentacaoImovel;
	
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SimNao pretendeMudar;

	private String MotivoVontadeMudanca;
	
	@NotBlank
	private String relacaoArea;
	
	@NotBlank
	private String relacaoVizinhos;
	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="localidade")
	private Localidade localidade;
	
	@JsonIgnore
	@OneToOne(mappedBy="imovel")
	private Entrevistado entrevistado;
	
	@JsonIgnore
	@OneToOne(mappedBy = "imovel")
	private DadosDeConsumo consumo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "imovel")
	private ServicosBasicos servicosBasicos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<Violencia> violenciaSofrida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<InstituicaoConhecida> instituicaoConhecida;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<AtividadeProdutiva> atividadeProdutiva;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<RendaOutrasFontes> rendaOutrasFontes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<Credito> credito;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private  List<Morador> morador;
	
}
