package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "PessoaFisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findByFKPessoaidPessoa", query = "SELECT p FROM PessoaFisica p WHERE p.fKPessoaidPessoa = :fKPessoaidPessoa"),
    @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")})
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_Pessoa_idPessoa")
    private Integer fKPessoaidPessoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "FK_Pessoa_idPessoa", referencedColumnName = "idPessoa", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer fKPessoaidPessoa) {
        this.fKPessoaidPessoa = fKPessoaidPessoa;
    }

    public PessoaFisica(Integer fKPessoaidPessoa, String cpf) {
        this.fKPessoaidPessoa = fKPessoaidPessoa;
        this.cpf = cpf;
    }

    public Integer getFKPessoaidPessoa() {
        return fKPessoaidPessoa;
    }

    public void setFKPessoaidPessoa(Integer fKPessoaidPessoa) {
        this.fKPessoaidPessoa = fKPessoaidPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fKPessoaidPessoa != null ? fKPessoaidPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.fKPessoaidPessoa == null && other.fKPessoaidPessoa != null) || (this.fKPessoaidPessoa != null && !this.fKPessoaidPessoa.equals(other.fKPessoaidPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoaFisica[ fKPessoaidPessoa=" + fKPessoaidPessoa + " ]";
    }
    
}
