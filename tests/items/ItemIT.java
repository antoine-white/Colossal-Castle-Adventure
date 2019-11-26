package items;

    import org.junit.Test;
    import static org.junit.Assert.*;
    
    public class ItemIT {
        @Test
        
        public void getNameTest(){
            String name1 = "test";
            String name2 = "";            
            Item i = new Item(name1,"");
            Item i2 = new Item(name2,"");            
            Item i3 = new Item(null,"");
            assertEquals(name1,i.getNAME());
            assertEquals(name2,i2.getNAME());
            assetNull(i3.getNAME());
        }

    
    }