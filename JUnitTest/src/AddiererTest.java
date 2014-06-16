import static org.junit.Assert.*;

import org.junit.Test;


public class AddiererTest {

	@Test
	public void test() {
		for (int i=0; i<100; i++){
			for (int j=0; j<100; j++){
				int erg = Addierer.addieren(i,j);
				assertTrue(erg+" ist das falsche Ergebnis", erg == i+j);
			}
		}
	}

}
