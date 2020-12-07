import java.util.ArrayList;

public class SIR {
    //Nbr de personnes saines
    private ArrayList<Integer> S;
    //Nbr de personnes Infectés
    private ArrayList<Integer> I;
    //Nbr de personnes guéris ou mortes
    private ArrayList<Integer> R;

    //Probabilité d'infecter quelq'un
    private float beta;

    //probabilité de ne plus être infecté
    private float gamma;

    //Temps de la simulation en Jours
    private int tempsSimulation;

    /**
     * @param S Nbr de personnes saines
     * @param I Nbr de personnes Infectés
     * @param R Nbr de personnes guéris ou mortes
     * @param beta Probabilité d'infecter quelq'un
     * @param gamma probabilité de ne plus être infecté
     * @param tempsSimulation Temps de la simulation en Jours
     */
    public SIR(int S, int I, int R, float beta, float gamma, int tempsSimulation) {
        this.S = new ArrayList<Integer>();
        this.I = new ArrayList<Integer>();
        this.R = new ArrayList<Integer>();
        this.S.add(S);
        this.I.add(I);
        this.R.add(R);
        this.beta = beta;
        this.gamma = gamma;
        this.tempsSimulation = tempsSimulation;
    }

    /**
     * Effectue la simulation
     */
    private void simuler() {
        for (int temps=0; temps<tempsSimulation; temps++) {
            int nbPersonnesDeSaI = (int) (beta*S.get(temps)*I.get(temps));
            if (nbPersonnesDeSaI > S.get(temps)) nbPersonnesDeSaI = S.get(temps);
            int nbPersonnesDeIaR = (int) (gamma*I.get(temps));

            S.add((S.get(temps) - nbPersonnesDeSaI));
            I.add((I.get(temps) + nbPersonnesDeSaI - nbPersonnesDeIaR));
            R.add((R.get(temps) + nbPersonnesDeIaR));
        }
    }

    /**
     * @return listeValeurs : un tableau composé des tableaux S, I et R
     */
    public ArrayList<ArrayList<Integer>> LancerSimulation() {
        simuler();
        ArrayList<ArrayList<Integer>> listeValeurs = new ArrayList<>();
        listeValeurs.add(S);
        listeValeurs.add(I);
        listeValeurs.add(R);
        return listeValeurs;
    }

    /**
     * @return S
     */
    public ArrayList<Integer> getS() {
        return S;
    }

    /**
     * @param s
     */
    protected void setS(ArrayList<Integer> s) {
        S = s;
    }

    /**
     * @return I
     */
    public ArrayList<Integer> getI() {
        return I;
    }

    /**
     * @param i
     */
    protected void setI(ArrayList<Integer> i) {
        I = i;
    }

    /**
     * @return R
     */
    public ArrayList<Integer> getR() {
        return R;
    }

    /**
     * @param r
     */
    protected void setR(ArrayList<Integer> r) {
        R = r;
    }

    /**
     * @return beta
     */
    public float getBeta() {
        return beta;
    }

    /**
     * @param beta
     */
    protected void setBeta(float beta) {
        this.beta = beta;
    }

    /**
     * @return gamma
     */
    public float getGamma() {
        return gamma;
    }

    /**
     * @param gamma
     */
    protected void setGamma(float gamma) {
        this.gamma = gamma;
    }

    /**
     * @return tempsSimulation
     */
    public int getTempsSimulation() {
        return tempsSimulation;
    }

    /**
     * @param tempsSimulation
     */
    protected void setTempsSimulation(int tempsSimulation) {
        this.tempsSimulation = tempsSimulation;
    }
}
