package com.example;

public class Jogo {
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();
    
    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador){
        if(jogador.parou()) return null;
       
        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;

    }

    public boolean acabou(){
        var osDoisPararam = jogador.parou() && computador.parou();
        var alguemEstourou = jogador.getPontos() > 21 || computador.getPontos() > 21;
        return osDoisPararam || alguemEstourou;
    }

    public String resultado(){
        var pontosIguais = jogador.getPontos() == computador.getPontos();
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();
 
        if(jogador.estorou() && computador.estorou() || pontosIguais){
            return "Empate";
        }

        if(!jogador.estorou() && (computador.estorou() || jogadorTemMaisPontos)){
            return "Você ganhou";
        }
        return "Você perdeu";
    }
}