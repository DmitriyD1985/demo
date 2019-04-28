class Product {
    public String name;
    public int weigth;
    public int cost;
    private double indexPolzi;

    public Product(String name, int weigth, int cost){
        this.name = name;
        this.weigth = weigth;
        this.cost = cost;
        indexPolzi = this.cost/this.weigth;
    }
    public double getIndex(){
        return indexPolzi;
    }
}
