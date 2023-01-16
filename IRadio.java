public interface IRadio {
    
    public void on(); //A
	
	public void off(); //A
	
	/***
	 * Este metodo nos indica si la radio esta encendida o apagada
	 * @return true si la radio esta encendida y false cuando la radio este apagada
	 */
	public boolean isOn();//A
	
	/***
	 * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
	 * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
	 */
	public void setFrequence(String freq) throws Exception; //A
	
	public String getFrequence(); //A
	
	public void Forward();
	
	public void Backward();
	
	public double getFMActualStation(); //A
	
	public int getAMActualStation(); //A
	
	public void setFMActualStation(double actualStation); //A
	
	public void setAMActualStation(int actualStation); //A
	
	public void saveFMStation(double actualStation, int slot);
	
	public void saveAMStation(int actualStation, int slot);
	
	public double getFMSlot(int slot);
	
	public int getAMSlot(int slot);
}
