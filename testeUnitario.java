package org.joda.money;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.junit.Test;



public class TestCurrencyUnit {
	
	// teste de como testar kk
	@Test
	public void test1_1Money() {
		Money myMoney = Money.of(CurrencyUnit.CAD,500);
		assertEquals("CAD 500.00", myMoney);
		
	}
	@Test
	public void test1_2Money() {
		Money myMoney = Money.of(CurrencyUnit.AUD,500);
		assertEquals("AUD 500.00", myMoney);	
	}
	
	
	
	// TEST CONSTANTES
	
	@Test
	public void test_Constants () {
		assertEquals(CurrencyUnit.USD, CurrencyUnit.of("USD"));
        assertEquals(CurrencyUnit.EUR, CurrencyUnit.of("EUR"));
        assertEquals(CurrencyUnit.JPY, CurrencyUnit.of("JPY"));
        assertEquals(CurrencyUnit.GBP, CurrencyUnit.of("GBP"));
        assertEquals(CurrencyUnit.CHF, CurrencyUnit.of("CHF"));
        assertEquals(CurrencyUnit.AUD, CurrencyUnit.of("AUD"));
        assertEquals(CurrencyUnit.CAD, CurrencyUnit.of("CAD"));
	}


	
	
	// TESTE MOEDAS
	
	@Test
	public void test_of_CurrencyUSD() { // Testes de Moeda USD
        CurrencyUnit test = CurrencyUnit.of("USD");
        assertEquals(test.getCode(), "USD");
    }
	@Test
	public void test_of_CurrencyEUR() { // Testes de Moeda EUR
        CurrencyUnit test = CurrencyUnit.of("EUR");
        assertEquals(test.getCode(), "EUR");
    }
	
	@Test
	public void test_of_CurrencyJPY() { // Testes de Moeda JPY
        CurrencyUnit test = CurrencyUnit.of("JPY");
        assertEquals(test.getCode(), "JPY");
    }
	
	@Test
	public void test_of_CurrencyGBP() { // Testes de Moeda GBP
        CurrencyUnit test = CurrencyUnit.of("GBP");
        assertEquals(test.getCode(), "GBP");
    }
	
	@Test
	public void test_of_CurrencyCHF() { // Testes de Moeda CHF
        CurrencyUnit test = CurrencyUnit.of("CHF");
        assertEquals(test.getCode(), "CHF");
    }
	
	@Test
	public void test_of_CurrencyAUD() { // Testes de Moeda AUD
        CurrencyUnit test = CurrencyUnit.of("AUD");
        assertEquals(test.getCode(), "AUD");
    }
	
	@Test
	public void test_of_CurrencyCAD() { // Testes de Moeda CAD
        CurrencyUnit test = CurrencyUnit.of("CAD");
        assertEquals(test.getCode(), "CAD");
    }
	
	
	
	
	// TESTE NOVA MOEDA
	
	@Test
	public void teste_NewCurrency () {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
	}
	
	@Test
	public void teste_NewCurrencyGetInstance () {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		assertEquals(CurrencyUnit.of("BRL"), CurrencyUnit.getInstance("BRL"));
	}
	
	
	
	// TESTE DE REFERENCIA A MOEDA ATRAVEZ DE CÓDIGO NUMERICO - STRING
	
	
	@Test
    public void test_ofNumericCode_String() {
        CurrencyUnit test = CurrencyUnit.ofNumericCode("826");
        assertEquals(test.getCode(), "GBP");
    }
	
	@Test
	public void test2_ofNumericCode_String() {
        CurrencyUnit test = CurrencyUnit.ofNumericCode("051");
        assertEquals(test.getCode(), "AMD");
    }
	
	@Test
    public void test_ofNumericCode_NewCurrency() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		
        CurrencyUnit test = CurrencyUnit.ofNumericCode("986");
        assertEquals(test.getCode(), "BRL");
    }
	
	@Test
    public void test_ofNumericCode_NewCurrencyADHOC() {
		CurrencyUnit.registerCurrency("AFA", 004, 0,Arrays.asList("AFA"), true);
		
        CurrencyUnit test = CurrencyUnit.ofNumericCode("004");
        assertEquals(test.getCode(), "AFA");
    }
	
	@Test
    public void test_ofNumericCode_NewCurrencyADHOC2() { // MOEDA EFEGÃ
		CurrencyUnit.registerCurrency("AFA", 4, 0,Arrays.asList("AFA"), true);
		
        CurrencyUnit test = CurrencyUnit.ofNumericCode("4");
        assertEquals(test.getCode(), "AFA");
    }
	
	@Test
    public void test_ofNumericCode_NewCurrencyErrorGuessing() {
		CurrencyUnit.registerCurrency("XFU", 0, 0,Arrays.asList("XFU"), true);
	
        CurrencyUnit test = CurrencyUnit.ofNumericCode("0");
       
        assertEquals(test.getCode(), "XFU");
    }
	
	
	@Test //provavel erro
    public void test_ofNumericCode_NewCurrencyErrorGuessing1() { 
		CurrencyUnit.registerCurrency("XFU", 0, 0,Arrays.asList("XFU"), true);
		CurrencyUnit.registerCurrency("VAL", 0, 0,Arrays.asList("VAL"), true);
		
		
        CurrencyUnit test = CurrencyUnit.ofNumericCode("0");
        CurrencyUnit test2 = CurrencyUnit.ofNumericCode("0");
       
        assertEquals(test.getCode(), "VAL");
        assertEquals(test2.getCode(), "XFU");
    }
	
	
	
	
	// TESTE DE REFERENCIA A MOEDA ATRAVEZ DE CÓDIGO NUMERICO - (INT)
	
	@Test
    public void test_ofNumericCode_int() {
        CurrencyUnit test = CurrencyUnit.ofNumericCode(840);
        assertEquals(test.getCode(), "USD");
    }
	
	
	
	
	// TESTE DE REFERENCIA A MOEDA ATRAVEZ DO LOCAL - Locale. *
	
	@Test
	  public void test_of_Locale() {
        CurrencyUnit test = CurrencyUnit.of(Locale.JAPAN);
        assertEquals(test.getCode(), "JPY");
	}

    
    
	// TESTANDO SE AS MOEDAS DAS CLASSES FAZEM PARTE DO REGISTRO DE MOEDAS - registeredCurrencies()
	

	
	
	@Test
	public void test_registeredCurrencies01() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("USD")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	
	@Test
	public void test_registeredCurrencies02() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("EUR")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	
	@Test
	public void test_registeredCurrencies03() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("JPY")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	@Test
	public void test_registeredCurrencies04() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("GBP")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	@Test
	public void test_registeredCurrencies05() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("CHF")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	@Test
	public void test_registeredCurrencies06() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("AUD")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	@Test
	public void test_registeredCurrencies07() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("CAD")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, true);
	}
	@Test
	public void test_registeredCurrenciesRandomFalse() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("WWW")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, false);
	}
	@Test
	public void test_registeredCurrenciesIncompletFalse() {
	    List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies();
	    boolean achou = false;
	    	for (CurrencyUnit currencyUnit : curList) {
	            if (currencyUnit.getCode().equals("C")) {
	                achou = true;
	                break;
	            }
	        }
	        assertEquals(achou, false);
	}
	

	
	// TESTANDO ORDENAÇÃO DAS MOEDAS COM COLECTION.SORT
	
	@Test
	public void test_registeredCurrencies1() {
		// verificando ordenação  das duas Listas Currency
		List<CurrencyUnit> curList1 = CurrencyUnit.registeredCurrencies();
		List<CurrencyUnit> curList2 = CurrencyUnit.registeredCurrencies();
		Collections.sort(curList2);
		assertEquals(curList1, curList2);
	}
	
	
	// TESTANDO getCurrencyCode()
	
	@Test
    public void test_getCurrencyCode_USD() {
        CurrencyUnit test = CurrencyUnit.of("USD");
        
        assertEquals(test.getCode(), "USD");
        assertEquals(test.getCurrencyCode(), "USD");
    }
	
	// TESTANDO gerNumericCode()
	
	@Test
	   public void test_getNumericCode_USD() {
        CurrencyUnit test = CurrencyUnit.of("USD");
        assertEquals(test.getNumericCode(), 840);
    }
	
	//TESTANDO casas decimais de qualquer moeda
	
	@Test
    public void test_DecimalPlaces_USD() {
        CurrencyUnit test = CurrencyUnit.of("USD");
        assertEquals(test.getDecimalPlaces(), 2);
    }
	// TEST Hash Code
	
	@Test
    public void test_hashCode() {
        CurrencyUnit usd = CurrencyUnit.of("GBP");
        CurrencyUnit jpy = CurrencyUnit.of("GBP");
        CurrencyUnit eur = CurrencyUnit.of("EUR");
        
        assertEquals(usd.equals(usd), true);
        assertEquals(jpy.equals(jpy), true);
        assertEquals(eur.equals(eur), true);
    }
	
	//TEST toString()
	
	@Test
    public void test_toString() {
        CurrencyUnit test = CurrencyUnit.of("USD");
        assertEquals(test.toString(), "USD");
    }
	
	// TESTES DE CUNHO EXPLORATÓRIO - UTILIZANDO OS TESTES JA REALIZADOS
	
	
	@Test
	public void test1_3Money() { // test de uso de uma Currency Criada
		
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		
		Money myMoney = Money.of(CurrencyUnit.of("BRL"),500);
		assertEquals("BRL 500.00", myMoney);	
	}
	
	@Test
	public void test_methodRegistered() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true); // criando a moeda Real do Brasil.
		
		List<CurrencyUnit> curList = CurrencyUnit.registeredCurrencies(); // testando se essa moeda consta como moeda registrada.
		boolean achou = false;
    	for (CurrencyUnit currencyUnit : curList) {
            if (currencyUnit.getCode().equals("BRL")) {
                achou = true;
                break;
            }
        }
        assertEquals(achou, true);
	}
	
	@Test
	public void test_registeredCurrencieseListEquals() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		
		// verificando ordenação  das duas Listas Currency com uma nova currency
		List<CurrencyUnit> curList1 = CurrencyUnit.registeredCurrencies();
		List<CurrencyUnit> curList2 = CurrencyUnit.registeredCurrencies();
		Collections.sort(curList2);
		assertEquals(curList1, curList2);
	}
	
	@Test
	public void test_of_CurrencyNEW_BRL() { // Testes de Moeda criada BRL
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		CurrencyUnit test = CurrencyUnit.of("BRL");
        assertEquals(test.getCode(), "BRL");
    }

	@Test
	public void test_getNumericCode_BRL() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
		CurrencyUnit test = CurrencyUnit.of("BRL");
		assertEquals(test.getNumericCode(), 986);
	}
	@Test
    public void test_DecimalPlaces_BRL() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
        CurrencyUnit test = CurrencyUnit.of("BRL");
        assertEquals(test.getDecimalPlaces(), 2);
    }
	
	@Test
    public void test_hashCodeBRL() {
		CurrencyUnit.registerCurrency("BRL", 986, 2,Arrays.asList("BRL"), true);
        
		CurrencyUnit usd = CurrencyUnit.of("GBP");
        CurrencyUnit jpy = CurrencyUnit.of("GBP");
        CurrencyUnit eur = CurrencyUnit.of("EUR");
        CurrencyUnit brl = CurrencyUnit.of("BRL");
        
        assertEquals(usd.equals(usd), true);
        assertEquals(jpy.equals(jpy), true);
        assertEquals(eur.equals(eur), true);
        assertEquals(brl.equals(brl), true);
    }
	 
}
