package tqs;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class stack<OBJ> 
{
    private int limit = 0;
    private ArrayList<OBJ> stck;

    public stack(){
        this.stck = new ArrayList<>();
    }

    public stack(int limit){
        this.limit = limit;
        this.stck = new ArrayList<>();
    }

    public int size(){
        return this.stck.size();
    }

    public void push(OBJ entrada){
        if(this.limit == 0){
            this.stck.add(entrada);
        }else{
            if(this.stck.size() < this.limit){
                this.stck.add(entrada);
            }else{
                throw new IllegalStateException();
            }
        }
    }

    public OBJ pop(){
        if (this.stck.isEmpty()){
            throw new NoSuchElementException();
        }else{
            return this.stck.remove(this.stck.size()-1);
        } 
    }
    
    public OBJ peek(){
        if (this.stck.isEmpty()){
            throw new NoSuchElementException();
        }else{
            return this.stck.get(this.stck.size()-1);
        }
    }

    public boolean isEmpty(){
        return this.stck.isEmpty();
    }

}
