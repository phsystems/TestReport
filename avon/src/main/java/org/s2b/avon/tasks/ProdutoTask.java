package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.ProdutoAppObject;

public class ProdutoTask {
	
	public static final String Retailer_URL = "https://www.avoncomigo.avon.com.br/webapp/wcs/stores/servlet/pt/avoncpg10/avonhomepage?langId=-6&catalogId=3074457345616677269&storeId=10658&krypto=ZInOkz04U6or5yA0DhC1ActA9NMr5jp%2Fyz7cgld%2FkHldVJZGozHgZ57wkoPSi3TkxYCG0ocRLh8AxmdIlKxPyTqO9fMbWdOvkphxupPUCsIXxYEDXa7qtQIvd7O8uGNIj%2FyzCPoeRo7SRp22kODqF2mKnm1dDET4qF9EjfqZP1gXi5Mc4I57HAr20f5LRmagerAoG8KY%2Fir8T%2FJVkpzVjBHspR1WhXzzHaZoOOw82%2F06OIDwV2MPvXQFRnfP41aKHtHcYssmxoHjbU7Bzh0JbKCBESg3Qv2FczCrmkukl9puyb4DAdP2I7vA9VqCFHIRC1LT2ZM%2BkVFExK1ztrb7%2FpwMl91JD9sd3WuBNgk4pC3O0IyQDrdPsMc1EZ2wPqNoPhUENrYKgHU8i5zcmeqTPXX4hpczAU8Z8MdwwuwHYygX%2FrNkX%2FsYFo9ZHEsDrSrT8AR0AjM1NHhoJEU1X69Gppcezs0uMHVVIdFS5duMpUsdJLP0PapLrjFUidXOUnvjABYjqNGzBz44ZvB36ongX%2BRVnxTJxCfIjRC7ijJ1J9WrAuWPgFk2gkwZfZT6pHtneuDv4qSdqMqE%2FnYO7MmWRA%3D%3D";
	
	private ProdutoAppObject search;
	private WebDriver driver;
	
	
	public ProdutoTask(WebDriver driver){
		this.search = new ProdutoAppObject(driver);
		this.driver = driver; 
		
	}
 
	public void fillProduto(String codigo){
		//search.getSeachClick().click();
		search.getSeachProduto().sendKeys(codigo);
	}
	public void searchProduto(){
		search.getSeachProdutoButton().click();
	}

	
	public void navigateToRetailerPage() {
		this.driver.get(Retailer_URL);
	}

}
