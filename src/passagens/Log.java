package passagens;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Log {
    private ArrayList<String> transacoes = new ArrayList<String>();

    public String getTransacoes() {
		String log = "";
        if(this.transacoes.isEmpty()) {
            return "O sistema ainda não possui log";
        }
        
        for(String transacao : this.transacoes) {
            log += (transacao + "\n");
        }
        return log;
	}

    public void addTransacao(String transacao) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();    
        this.transacoes.add(dtf.format(now) + " | " + transacao);
    }
    
}
