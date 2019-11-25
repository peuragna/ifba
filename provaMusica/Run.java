public class Run{
    Playlist playlist1 = new Playlist("um");
    Playlist playlist2 = new Playlist("dois");
    
    String[] p1m1lista = {"Joao","Maria","Carlos"};
    String[] p1m2lista = {"Joao","Maria","Carlos"};
    String[] p1m3lista = {"Joao","Maria","Carlos"};
    String[] p1m4lista = {"Joao","Maria","Carlos"};
    String[] p1m5lista = {"Joao","Maria","Carlos"};
    
    String[] p2m1lista = {"Joao","Maria","Carlos"};
    String[] p2m2lista = {"Joao","Maria","Carlos"};
    String[] p2m3lista = {"Joao","Maria","Carlos"};
    String[] p2m4lista = {"Joao","Maria","Carlos"};
    String[] p2m5lista = {"Joao","Maria","Carlos"};
    
    public void ex(){
        
        //Povoando a lista 1
        
        Musica p1m1 = new Musica("Teste","Teste","Teste",p1m1lista,Campo.D,35);
        playlist1.addMusica(p1m1);
        
        Musica p1m2 = new Musica("Teste","Teste","Teste",p1m2lista,Campo.D,35);
        playlist1.addMusica(p1m2);
        
        Musica p1m3 = new Musica("Teste","Teste","Teste",p1m3lista,Campo.D,35);
        playlist1.addMusica(p1m3);
        
        Musica p1m4 = new Musica("Teste","Teste","Teste",p1m4lista,Campo.D,35);
        playlist1.addMusica(p1m4);
        
        Musica p1m5 = new Musica("Teste","Teste","Teste",p1m5lista,Campo.D,35);
        playlist1.addMusica(p1m5);    
        
        //Povoando a lista 2
        
        Musica p2m1 = new Musica("Teste","Teste","Teste",p2m1lista,Campo.D,35);
        playlist2.addMusica(p2m1);
        
        Musica p2m2 = new Musica("Teste","Teste","Teste",p2m2lista,Campo.D,35);
        playlist2.addMusica(p2m2);
        
        Musica p2m3 = new Musica("Teste","Teste","Teste",p2m3lista,Campo.D,35);
        playlist2.addMusica(p2m3);
        
        Musica p2m4 = new Musica("Teste","Teste","Teste",p2m4lista,Campo.D,35);
        playlist2.addMusica(p2m4);
        
        Musica p2m5 = new Musica("Teste","Teste","Teste",p2m5lista,Campo.D,35);
        playlist2.addMusica(p2m5);    
        
    };

}
