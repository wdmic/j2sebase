
public class BinarySearch {
	/**
	 * 冒泡法排序
	 * 二分法搜索Date
	 * @param args
	 */

	public static void main(String[] args) {
		Date[] dates = new Date[5];
		dates[0] = new Date(2016, 7, 20);
		dates[1] = new Date(2018, 7, 20);
		dates[2] = new Date(2017, 4, 23);
		dates[3] = new Date(2016, 7, 15);
		dates[4] = new Date(2018, 3, 28);
		//查找的元素
		Date d = new Date(2018, 3, 28);
		
		bubbleSort(dates);
		for (Date date : dates) {
			System.out.println(date);
		}
		
		System.out.println(binarySearch(dates, d));

	}
	
	/**
	 * 冒泡法
	 * @param dates
	 */
	public static void bubbleSort(Date[] dates) {
		for (int i = 1; i < dates.length; i++) {
			for (int j = 0; j < dates.length-i; j++) {
				if (dates[j].compare(dates[j+1]) > 0) {
					Date temp = dates[j];
					dates[j] = dates[j+1];
					dates[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 二分法搜索
	 */
	public static int binarySearch(Date[] dates, Date date) {
		if (dates.length == 0) {
			return -1;
		}
		int startPos = 0;
		int endPos = dates.length-1;
		int m = (startPos + endPos)/2;
		while (startPos <= endPos) {
			if (dates[m].compare(date) == 0) {
				return m;
			}
			if (dates[m].compare(date) < 0) {
				startPos = m+1;
			}
			if (dates[m].compare(date) > 0) {
				endPos = m-1;
			}
			m = (startPos + endPos) /2;
		}
		return -1;
		
	}

}

class Date{
	int year, month, day;
	public Date(int year, int month, int day) {
		this.day = day;
		this.year = year;
		this.month = month;
	}
	public int compare(Date date) {
		return year > date.year? 1
				: year <date.year? -1
				: month > date.month ? 1
				: month < date.month ? -1
				: day > date.day ? 1
				: day < date.day ? -1 : 0;
	}
	@Override
	public String toString() {
		return "Date [" + year + "." + month + "." + day + "]";
	}
	
}
