package src;
import xmetamodel.XClass;

import com.salexandru.corex.interfaces.IPropertyComputer;
import com.salexandru.corex.metaAnnotation.PropertyComputer;


@PropertyComputer
public class A implements IPropertyComputer<Integer, XClass> {
	@Override
	public Integer compute(XClass entity) {
		return 0;
	}
}










