package com.dreaouth.encrypt;

import com.dreaouth.model.Passenger;
import com.dreaouth.model.Plane;
import fpeforUse.FunctionForFPE;

import java.util.Date;
import java.util.List;


public class FinalFunction {
	static public void EncryForPassenger(Passenger passenger, byte[] aesKeyFor128){
		Integer id = passenger.getId();
		String name = passenger.getName();
		Integer age = passenger.getAge();
		Long tel = passenger.getTel();
		String card = passenger.getCard();
		String Seat = passenger.getSeat();
		Integer planeId = passenger.getPlaneId();
		passenger.setName(((FunctionForFPE.EncrypForName(name , aesKeyFor128, id))));
		if(age > 100){
			passenger.setAge(FunctionForFPE.EncryedForInteger(age, aesKeyFor128, id));
		}
		else{
			passenger.setAge(FunctionForFPE.EncryShortNumber(age, aesKeyFor128, id));
		}
		passenger.setTel(FunctionForFPE.EncryedForLong(tel, aesKeyFor128, id));
		passenger.setCard(FunctionForFPE.EncryStringIFX(card, aesKeyFor128, id));
		passenger.setSeat(FunctionForFPE.EncryStringIFX(Seat, aesKeyFor128, id));
		if(planeId > 100){
			passenger.setPlaneId(FunctionForFPE.EncryedForInteger(planeId, aesKeyFor128, id));
		}else{
			passenger.setPlaneId(FunctionForFPE.EncryShortNumber(planeId,aesKeyFor128,id));
		}

	}
	static public void DecryForPassDeger(Passenger passenger,byte[] aesKeyFor128){
		Integer id = passenger.getId();
		String name = passenger.getName();
		Integer age = passenger.getAge();
		Long tel = passenger.getTel();
		String card = passenger.getCard();
		String Seat = passenger.getSeat();
		Integer planeId = passenger.getPlaneId();
		passenger.setName((FunctionForFPE.DecrypForName(name, aesKeyFor128, id)));
		passenger.setAge(FunctionForFPE.DecryedForInteger(age, aesKeyFor128, id));
		passenger.setTel(FunctionForFPE.DecryedForLong(tel, aesKeyFor128, id));
		passenger.setCard(FunctionForFPE.DecryStringIFX(card, aesKeyFor128, id));
		passenger.setSeat(FunctionForFPE.DecryStringIFX(Seat, aesKeyFor128, id));
		if(planeId > 100) {
			passenger.setPlaneId(FunctionForFPE.DecryedForInteger(planeId, aesKeyFor128, id));
		}else{
			passenger.setPlaneId(FunctionForFPE.EncryShortNumber(planeId,aesKeyFor128,id));
		}
	}
	static public void EncryForPassengers(List<Passenger> passengers,byte[] aesKeyFor128){
		for(Passenger passenger:passengers){
			EncryForPassenger(passenger,aesKeyFor128);
		}
	}
	static public void DecryForPassengers(List<Passenger> passengers,byte[] aesKeyFor128){
		for(Passenger passenger:passengers){
			DecryForPassDeger(passenger,aesKeyFor128);
		}
	}
	static public void EncryForPlane(Plane plane, byte[] aesKeyFor128){
		//	DateFormat Myformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer id = plane.getId();
		String airlinecode = plane.getAirlinecode();
		String arriveDrome = plane.getArriveDrome();
		String arrive_time = plane.getArriveTime();
		String company = plane.getCompany();
		String date_string = plane.getDate();
		String mode = plane.getMode();
		Integer number = plane.getNumber();
		Integer price = plane.getPrice();
		String startDrome = plane.getStartDrome();
		String startTime = plane.getStartTime();
		plane.setAirlinecode(FunctionForFPE.EncryStringIFX(airlinecode, aesKeyFor128, id));
		plane.setArriveDrome(FunctionForFPE.EncryStringIFX(arriveDrome, aesKeyFor128, id));
		plane.setArriveTime(FunctionForFPE.EncryAccurateTime(arrive_time, aesKeyFor128, id));
		plane.setCompany(FunctionForFPE.EncryStringIFX(company, aesKeyFor128, id));
		//        Date date = new Date();
		//        FunctionForFPE.AdaptStringForDate(date_string, startTime,date);
		//     System.out.println("date="+Myformat.format(date));
		//        String completeDate = Myformat.format(FunctionForFPE.EncryTime(date, aesKeyFor128, id));
		//        String token[] = completeDate.split("\\s+");
		//        plane.setDate(token[0]);
		//        plane.setStartTime(token[1]);
		plane.setDate(FunctionForFPE.EncryRough(date_string, aesKeyFor128, id));
		plane.setStartTime(FunctionForFPE.EncryAccurateTime(startTime, aesKeyFor128, id));
		plane.setMode(FunctionForFPE.EncryStringIFX(mode, aesKeyFor128, id));
		if(number > 100){
			plane.setNumber(FunctionForFPE.EncryedForInteger(number, aesKeyFor128, id));
		}
		else{
			plane.setNumber(FunctionForFPE.EncryShortNumber(number, aesKeyFor128, id));
		}
		if(price > 100){
			plane.setPrice(FunctionForFPE.EncryedForInteger(price, aesKeyFor128, id));
		}
		else{
			plane.setPrice(FunctionForFPE.EncryShortNumber(price, aesKeyFor128, id));
		}
		plane.setStartDrome(FunctionForFPE.EncryStringIFX(startDrome, aesKeyFor128, id));

	}
	static public void DecryForPlane(Plane plane,byte[] aesKeyFor128){
		// 	DateFormat Myformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer id = plane.getId();
		String airlinecode = plane.getAirlinecode();
		String arriveDrome = plane.getArriveDrome();
		String arrive_time = plane.getArriveTime();
		String company = plane.getCompany();
		String date_string = plane.getDate();
		String mode = plane.getMode();
		Integer number = plane.getNumber();
		Integer price = plane.getPrice();
		String startDrome = plane.getStartDrome();
		String startTime = plane.getStartTime();
		plane.setAirlinecode(FunctionForFPE.DecryStringIFX(airlinecode, aesKeyFor128, id));
		plane.setArriveDrome(FunctionForFPE.DecryStringIFX(arriveDrome, aesKeyFor128, id));
		plane.setArriveTime(FunctionForFPE.DecryAccurateTime(arrive_time, aesKeyFor128, id));
		plane.setCompany(FunctionForFPE.DecryStringIFX(company, aesKeyFor128, id));
		Date date = new Date();
		//        FunctionForFPE.AdaptStringForDate(date_string, startTime,date);
		////        System.out.println(Myformat.format(date));
		//        String completeDate = Myformat.format(FunctionForFPE.DecryTime(date, aesKeyFor128, id));
		//        String token[] = completeDate.split("\\s+");
		//        plane.setDate(token[0]);
		//        plane.setStartTime(token[1]);
		plane.setDate(FunctionForFPE.DecryRough(date_string, aesKeyFor128, id));
		plane.setStartTime(FunctionForFPE.DecryAccurateTime(startTime, aesKeyFor128, id));
		plane.setMode(FunctionForFPE.DecryStringIFX(mode, aesKeyFor128, id));
		plane.setNumber(FunctionForFPE.DecryedForInteger(number, aesKeyFor128, id));
		plane.setPrice(FunctionForFPE.DecryedForInteger(price, aesKeyFor128, id));
		plane.setStartDrome(FunctionForFPE.DecryStringIFX(startDrome, aesKeyFor128, id));
	}
	static public void EecryForPlanes(List<Plane> planes,byte[] aesKeyFor128){
		for(Plane plane:planes){
			EncryForPlane(plane,aesKeyFor128);
		}
	}
	static public void DecryForPlanes(List<Plane> planes,byte[] aesKeyFor128){
		for(Plane plane:planes){
			DecryForPlane(plane,aesKeyFor128);
		}
	}
}