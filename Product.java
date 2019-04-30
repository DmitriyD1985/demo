class Product {
    public int getCost;
    private String name;
    private int weigth;
    private int cost;

    public Product(String name, int weigth, int cost){
        this.name = name;
        this.weigth = weigth;
        this.cost = cost;
    }

    public void setName(String name){
        this.name = name;}
    public void setWeigth(int weigth){
        this.weigth = weigth;
    }
    public void setCost(int cost){
        this.cost = cost;
    }

    public String getName(){
        return name;
    }
    public int getWeigth(){
        return weigth;
    }
    public int getCost(){
        return cost;
    }
}
