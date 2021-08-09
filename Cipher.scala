//Encryption and Decryption using Caesor Cipher
object Cipher{

    //Encryption
    def encrypt(text:String,n:Int,alphabet:String): String ={   

        val E=(c:Char,key:Int,a:String) => a((a.indexOf(c.toUpper)+key)%a.size); //shift to right
        val cipher=(algo:(Char,Int,String) => Char,s:String,key:Int,a:String) => text.map(algo(_,key,a));
        val ct=cipher(E,text,n,alphabet); //encryption

        return ct;
    }
    //Decryption
    def decrypt(text:String,n:Int,alphabet:String): String ={
        
        val D=(c:Char,key:Int,a:String) => a((a.indexOf(c.toUpper)-key)%a.size); //shift to left
        val cipher=(algo:(Char,Int,String) => Char,s:String,key:Int,a:String) => text.map(algo(_,key,a));
        val pt=cipher(D,text,n,alphabet); //decryption

        return pt;        
    }
    def main(args: Array[String]): Unit = {
        val text = "PROSECUTER";
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        val shift = 5;

        val ct = encrypt(text,shift,alphabet);
        val pt = decrypt(ct,shift,alphabet);

        println("Text : " + text);
        println("After encryption: " + ct );
        println("After decryption: " + pt );
    }
}