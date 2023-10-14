package rocket;

public abstract class Carro {
    private int id;
    private int idTrem;

    public Carro(int id){
        this.id = id;
        this.idTrem = 0;
    }

    public int getId(){
        return id;
    }

    public int getIdTrem(){
        return idTrem;
    }

    public void setIdTrem(int idTrem) {
        this.idTrem = idTrem;
    }

    public String toString(){
        return "Carro [" + id + ", Tipo: ";
    }
}
