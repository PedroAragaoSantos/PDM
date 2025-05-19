package com.ifsc.contaclique;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> planetas;
    public PlanetaDao(){
        this.planetas=new ArrayList<>();
        String [] nomes = new String[]{"Mercurio","Venus","Terra","Marte","Jupiter","Saturno","Urano","Netuno"};
        Integer[] imagens = new Integer[]{R.drawable.mercury,R.drawable.venus,
                R.drawable.earth,R.drawable.mars,
                R.drawable.jupter,R.drawable.saturn,
                R.drawable.uranus,R.drawable.neptune};
        for(int i=0; i<nomes.length; i++){
            planetas.add(new Planeta(nomes[i],imagens[i] ));
        }
    }

    public ArrayList<Planeta> getPlaneta(){
        return this.planetas;
    }
}
