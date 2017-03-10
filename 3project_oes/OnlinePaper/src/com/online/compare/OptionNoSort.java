package com.online.compare;
import java.util.Comparator;

import com.online.domain.Questiondetail;
public class OptionNoSort implements Comparator{
public int compare(Object o1, Object o2) {
  Questiondetail  qt1=(Questiondetail)o1;
  Questiondetail  qt2=(Questiondetail)o2;
  return qt1.getOptionNo().compareTo(qt2.getOptionNo());
}
}