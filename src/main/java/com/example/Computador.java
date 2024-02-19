package com.example;

public class Computador extends Jogador {
    @Override
    public boolean parou() {
      var computadorTemVantagem = this.getPontos() == 21 || this.getPontos() < getPontos();
      if(computadorTemVantagem) return true;
      return getPontos() > 16;
    }
}