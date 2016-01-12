 /* Copyright (c) 1996-2015, OPC Foundation. All rights reserved.
   The source code in this file is covered under a dual-license scenario:
     - RCL: for OPC Foundation members in good-standing
     - GPL V2: everybody else
   RCL license terms accompanied with this source code. See http://opcfoundation.org/License/RCL/1.00/
   GNU General Public License as published by the Free Software Foundation;
   version 2 of the License are accompanied with this source code. See http://opcfoundation.org/License/GPLv2
   This source code is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
*/

package org.opcfoundation.ua.core;

import org.opcfoundation.ua.builtintypes.Structure;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import org.opcfoundation.ua.builtintypes.LocalizedText;
import org.opcfoundation.ua.builtintypes.UnsignedInteger;
import org.opcfoundation.ua.core.NodeAttributes;



public class ReferenceTypeAttributes extends NodeAttributes implements Structure, Cloneable {
	
	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.ReferenceTypeAttributes);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.ReferenceTypeAttributes_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.ReferenceTypeAttributes_Encoding_DefaultXml);
	
    protected Boolean IsAbstract;
    protected Boolean Symmetric;
    protected LocalizedText InverseName;
    
    public ReferenceTypeAttributes() {}
    
    public ReferenceTypeAttributes(UnsignedInteger SpecifiedAttributes, LocalizedText DisplayName, LocalizedText Description, UnsignedInteger WriteMask, UnsignedInteger UserWriteMask, Boolean IsAbstract, Boolean Symmetric, LocalizedText InverseName)
    {
        super(SpecifiedAttributes, DisplayName, Description, WriteMask, UserWriteMask);
        this.IsAbstract = IsAbstract;
        this.Symmetric = Symmetric;
        this.InverseName = InverseName;
    }
    
    public Boolean getIsAbstract()
    {
        return IsAbstract;
    }
    
    public void setIsAbstract(Boolean IsAbstract)
    {
        this.IsAbstract = IsAbstract;
    }
    
    public Boolean getSymmetric()
    {
        return Symmetric;
    }
    
    public void setSymmetric(Boolean Symmetric)
    {
        this.Symmetric = Symmetric;
    }
    
    public LocalizedText getInverseName()
    {
        return InverseName;
    }
    
    public void setInverseName(LocalizedText InverseName)
    {
        this.InverseName = InverseName;
    }
    
    /**
      * Deep clone
      *
      * @return cloned ReferenceTypeAttributes
      */
    public ReferenceTypeAttributes clone()
    {
        ReferenceTypeAttributes result = new ReferenceTypeAttributes();
        result.SpecifiedAttributes = SpecifiedAttributes;
        result.DisplayName = DisplayName;
        result.Description = Description;
        result.WriteMask = WriteMask;
        result.UserWriteMask = UserWriteMask;
        result.IsAbstract = IsAbstract;
        result.Symmetric = Symmetric;
        result.InverseName = InverseName;
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ReferenceTypeAttributes other = (ReferenceTypeAttributes) obj;
        if (SpecifiedAttributes==null) {
            if (other.SpecifiedAttributes != null) return false;
        } else if (!SpecifiedAttributes.equals(other.SpecifiedAttributes)) return false;
        if (DisplayName==null) {
            if (other.DisplayName != null) return false;
        } else if (!DisplayName.equals(other.DisplayName)) return false;
        if (Description==null) {
            if (other.Description != null) return false;
        } else if (!Description.equals(other.Description)) return false;
        if (WriteMask==null) {
            if (other.WriteMask != null) return false;
        } else if (!WriteMask.equals(other.WriteMask)) return false;
        if (UserWriteMask==null) {
            if (other.UserWriteMask != null) return false;
        } else if (!UserWriteMask.equals(other.UserWriteMask)) return false;
        if (IsAbstract==null) {
            if (other.IsAbstract != null) return false;
        } else if (!IsAbstract.equals(other.IsAbstract)) return false;
        if (Symmetric==null) {
            if (other.Symmetric != null) return false;
        } else if (!Symmetric.equals(other.Symmetric)) return false;
        if (InverseName==null) {
            if (other.InverseName != null) return false;
        } else if (!InverseName.equals(other.InverseName)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((SpecifiedAttributes == null) ? 0 : SpecifiedAttributes.hashCode());
        result = prime * result
                + ((DisplayName == null) ? 0 : DisplayName.hashCode());
        result = prime * result
                + ((Description == null) ? 0 : Description.hashCode());
        result = prime * result
                + ((WriteMask == null) ? 0 : WriteMask.hashCode());
        result = prime * result
                + ((UserWriteMask == null) ? 0 : UserWriteMask.hashCode());
        result = prime * result
                + ((IsAbstract == null) ? 0 : IsAbstract.hashCode());
        result = prime * result
                + ((Symmetric == null) ? 0 : Symmetric.hashCode());
        result = prime * result
                + ((InverseName == null) ? 0 : InverseName.hashCode());
        return result;
    }
    


	public ExpandedNodeId getTypeId() {
		return ID;
	}

	public ExpandedNodeId getXmlEncodeId() {
		return XML;
	}

	public ExpandedNodeId getBinaryEncodeId() {
		return BINARY;
	}
	
	public String toString() {
		return "ReferenceTypeAttributes: "+ObjectUtils.printFieldsDeep(this);
	}

}
