package ContaJava;
    public class Conta {
        public int numConta;
        protected String tipo;
        private String nomeDono;
        private float saldo = 0.0F;
        private boolean status = false;
        private int bonusCC = 50;
        private int bonusCp = 100;
        private int tarifaContaCc = 20;
        private int tarifaContaCp = 10;
        String informContaAberta = " Conta aberta com sucesso ";
        String informContaFechada = " Sua conta foi encerrada ";

        public Conta() {
        }

        public int getNumConta() {
            return this.numConta;
        }

        public void setNumConta(int numeroConta) {
            this.numConta = numeroConta;
        }

        public String getTipo() {
            return this.tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNomeDono() {
            return this.nomeDono;
        }

        public void setNomeDono(String nomeDono) {
            this.nomeDono = nomeDono;
        }

        public float getSaldo() {
            return this.saldo;
        }

        public void setSaldo(float saldo) {
            this.saldo = saldo;
        }

        public boolean getStatus() {
            return this.status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getTarifaContaCc() {
            return this.tarifaContaCc;
        }

        public void setTarifaContaCc(int tarifaContaCc) {
            this.tarifaContaCc = tarifaContaCc;
        }

        public int getTarifaContaCp() {
            return this.tarifaContaCp;
        }

        public void setTarifaContaCp(int tarifaContaCp) {
            this.tarifaContaCp = tarifaContaCp;
        }

        public int getBonusCC() {
            return this.bonusCC;
        }

        public void setBonusCC(int bonusCC) {
            this.bonusCC = bonusCC;
        }

        public int getBonusCp() {
            return this.bonusCp;
        }

        public void setBonusCp(int bonusCp) {
            this.bonusCp = bonusCp;
        }

        public String toString() {
            return "Conta : " + this.getNumConta() +
                    "\n"+ "Tipo : " + this.getTipo() + "\n"+
                    "Usuário : " + this.getNomeDono() + "\n"
                    +"Aberta : " + this.getStatus() + "\n"
                    +"Saldo : " + this.getSaldo();
        }

        public void abrirConta(String tipo) {
            this.setStatus(true);
            this.setTipo(tipo);
            if (tipo.toLowerCase().equals("cp")) {
                this.setSaldo((float)this.getBonusCp());
            }

            if (tipo.toLowerCase().equals("cc")) {
                this.setSaldo((float)this.getBonusCC());
            }

            System.out.println(this.informContaAberta);
        }

        public void fecharConta() {
            if (this.getSaldo() == 0.0F) {
                this.setStatus(false);
            }

        }

        public void depositar(float valor) {
            if (this.getStatus()) {
                this.setSaldo(this.getSaldo() + valor);
            }

        }

        public void sacar(float valorSc) {
            if (this.getStatus() && this.getSaldo() >= valorSc) {
                this.setSaldo(this.getSaldo() - valorSc);
            }

        }

        public void pagamentoMensal() {
            float tarifa = 0.0F;
            if ("cc".equals(this.getTipo().toLowerCase())) {
                tarifa = (float)this.getTarifaContaCc();
            }

            if ("cp".equals(this.getTipo().toLowerCase())) {
                tarifa = (float)this.getTarifaContaCp();
            }

            if (this.getStatus()) {
                if (this.getSaldo() >= tarifa) {
                    this.setSaldo(this.getSaldo() - tarifa);
                }
            } else {
                System.out.println("impossível fazer o pagamento");
            }

        }
    }


