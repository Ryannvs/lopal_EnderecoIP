package br.senai.dev.ryan.model;

public class MascaraSubRede {
	int prefix;

    public  MascaraSubRede(int p) {
        if (p < 0 || p > 32) throw new RuntimeException("Prefixo inválido");
        prefix = p;
    }

    public String getDecimal() {
        int m = prefix == 0 ? 0 : (0xFFFFFFFF << (32 - prefix));
        int[] oct = new int[4];
        for (int i = 0; i < 4; i++) oct[i] = (m >> (24 - 8*i)) & 0xFF;
        return oct[0] + "." + oct[1] + "." + oct[2] + "." + oct[3];
    }

    public String getBinary() {
        String s = "";
        int m = prefix == 0 ? 0 : (0xFFFFFFFF << (32 - prefix));
        for (int i = 0; i < 4; i++) {
            String b = Integer.toBinaryString((m >> (24 - 8*i)) & 0xFF);
            while (b.length() < 8) b = "0" + b;
            s += b + (i<3?".":"");
        }
        return s;
    }

    public int getHosts() {
        int bits = 32 - prefix;
        int total = (int)Math.pow(2, bits);
        if (bits > 1) total -= 2;
        return total;
    }

}
