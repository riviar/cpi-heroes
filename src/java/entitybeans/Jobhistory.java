/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitybeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "jobhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobhistory.findAll", query = "SELECT j FROM Jobhistory j"),
    @NamedQuery(name = "Jobhistory.findByIdjobs", query = "SELECT j FROM Jobhistory j WHERE j.idjobs = :idjobs"),
    @NamedQuery(name = "Jobhistory.findByProcessid", query = "SELECT j FROM Jobhistory j WHERE j.processid = :processid"),
    @NamedQuery(name = "Jobhistory.findByCommandused", query = "SELECT j FROM Jobhistory j WHERE j.commandused = :commandused")})
public class Jobhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjobs")
    private Integer idjobs;
    @Column(name = "processid")
    private Integer processid;
    @Size(max = 9999)
    @Column(name = "commandused")
    private String commandused;
    @JoinColumn(name = "experimentid", referencedColumnName = "idexperiments")
    @ManyToOne(optional = false)
    private Experiments experimentid;
    @JoinColumn(name = "toolid", referencedColumnName = "toolid")
    @ManyToOne
    private Tools toolid;

    public Jobhistory() {
    }

    public Jobhistory(Integer idjobs) {
        this.idjobs = idjobs;
    }

    public Integer getIdjobs() {
        return idjobs;
    }

    public void setIdjobs(Integer idjobs) {
        this.idjobs = idjobs;
    }

    public Integer getProcessid() {
        return processid;
    }

    public void setProcessid(Integer processid) {
        this.processid = processid;
    }

    public String getCommandused() {
        return commandused;
    }

    public void setCommandused(String commandused) {
        this.commandused = commandused;
    }

    public Experiments getExperimentid() {
        return experimentid;
    }

    public void setExperimentid(Experiments experimentid) {
        this.experimentid = experimentid;
    }

    public Tools getToolid() {
        return toolid;
    }

    public void setToolid(Tools toolid) {
        this.toolid = toolid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjobs != null ? idjobs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobhistory)) {
            return false;
        }
        Jobhistory other = (Jobhistory) object;
        if ((this.idjobs == null && other.idjobs != null) || (this.idjobs != null && !this.idjobs.equals(other.idjobs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitybeans.Jobhistory[ idjobs=" + idjobs + " ]";
    }
    
}
