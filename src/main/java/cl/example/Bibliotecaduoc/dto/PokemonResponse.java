package cl.example.Bibliotecaduoc.dto;


//DTO simple para consumir PokeApi - solo campos basicos

public class PokemonResponse {

    private Long id;
    private String name;

    private Boolean is_legendary;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Boolean GetIs_legendary(){
        return is_legendary;
    }

    public void setIs_legendary(Boolean isLegendary){
        this.is_legendary = isLegendary;
    }

}
