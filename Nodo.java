class Nodo{

  private int info;
  private Nodo izq;
  private Nodo der;

  public Nodo(int info){
    this.info = info;
    this.izq = null;
    this.der = null;
  }
  public Nodo (int info, Nodo izq, Nodo der){
    this.info = info;
    this.izq = izq;
    this.der = der;
  }
  public int getInfo(){
    return this.info;
  }
  public Nodo getIzq(){
    return this.izq;
  }
  public Nodo getDer(){
    return this.der;
  }
  public void setInfo(int info){
    this.info = info;
  }
  public void setIzq (Nodo izq){
    this.izq = izq;
  }
  public void setDer (Nodo der){
    this.der = der;
  }
  public String toString(){
    return "Izq : " + this.izq + " Info : " + this.info + " Der : " + this.der;
  }

}