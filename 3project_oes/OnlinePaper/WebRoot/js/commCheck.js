/*�ж��Ƿ�Ϊ��*/
function  checkNull(obj)
  {
     if (obj.length==0) 
         {
         return false;
         }
     else
         {
         return true; 
         }
  }  
  
/*�ж��Ƿ�Ϊ����*/
function checkNumber(obj)
 {
    if(isNaN(obj))    
    {    
     return false;    
    }
    else
     {
      return true;
     }    
 }
 
 
 
 
 
 /*����������ȫ��Ϊ�ж����ڵ�javascript�ű�*/
 
 //�ж�����������Ƿ�Ϊ���ڸ�ʽ

function checkDateFormate(Field) {
    var inputDateValue = Field.value;
    var desc = Field.name;
    if(inputDateValue == null || inputDateValue == '') {
       return false;
    }

    //��ȡ�����ַ����ĳ���

    var inputValueLength = inputDateValue.length;

    //������������жϵ�������������Ϸ������ڣ����򲻺Ϸ�

    if(checkNumeric(inputDateValue) && checkLegth(inputValueLength) && checkSpecialChar(inputDateValue) ) {

       return true;

    }else {

//errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
  //alert("������Ϸ���" + "\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");

  //     Field.focus();

       return false;

    } 

}

//����ֻ����8~10λ

function checkLegth(length) {

    if(length < 8 || length > 10) {

       return false;

    }

    return true;

}

//�������������а�����-�������ա�-���ָ���ȥ�����գ�����ֱ�Ӱ���λ��ȡ

function checkSpecialChar(inputDateValue) {

    var index = inputDateValue.indexOf('-');

    var year = 0;

    var month = 0;

    var day = 0;

    if(index > -1) {

       var lastIndex = inputDateValue.lastIndexOf('-');

       //ֻ����YYYY-M-DD����YYYY-MM-DD����ʽ

       if(lastIndex - index < 1 || lastIndex - index > 3) {

           return false;

       }

       var arrDate = inputDateValue.split('-');

           year = arrDate[0];

           month = arrDate[1];

           day = arrDate[2];

       } else {

           year = inputDateValue.substring(0,4);

           month = inputDateValue.substring(4,6);

           day = inputDateValue.substring(6,8);

       }

       if(Number(month) > 12 || Number(day) > 31 ||Number(month)<1

                           || Number(day)<1 ||  year.length != 4) {

           return false;

    } else  if(day > getLastDayOfMonth(Number(year),Number(month))) {

           return false;

    }

    return true;

}

//�ж���������ݽ���-���滻��Ϊ����1���Ƿ�ȫ��Ϊ����

function checkNumeric(inputDateValue) {

    var replacedValue = inputDateValue.replace(/-/g,'1');

    return isNumeric(replacedValue);

}

//�ж��Ƿ�Ϊ����

function isNumeric(strValue)

{

  var result = regExpTest(strValue,/\d*[.]?\d*/g);

  return result;

}

 

function regExpTest(source,re)

{

  var result = false;

 

  if(source==null || source=="")

    return false;

 

  if(source==re.exec(source))

    result = true;

 

  return result;

}

 

//���һ�����е����һ��

function getLastDayOfMonth(year,month){

    var days=0;

    switch(month){

    case 1: case 3: case 5: case 7: case 8: case 10: case 12: days=31;break;

    case 4: case 6: case 9: case 11: days=30;break;

    case 2: if(isLeapYear(year)) days=29;else days=28;break;

    }

    return days;

}

//�ж��Ƿ�Ϊ����

function isLeapYear(year){

    if((year %4==0 && year %100!=0) || (year %400==0)) return true;

    else return false;

}
