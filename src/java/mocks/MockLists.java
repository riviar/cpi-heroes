/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocks;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fox
 */
@ManagedBean(name = "MockLists")
@RequestScoped
public class MockLists {

    private List<String> inputs;

    public List<String> getInputs() {
        return inputs;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }
    /**
     * Creates a new instance of MockLists
     */
    public MockLists() {
        inputs = new ArrayList();
        inputs.add("File 1");
        inputs.add("File 2");
        inputs.add("File 3");
        inputs.add("File 4");
    }
    
}
