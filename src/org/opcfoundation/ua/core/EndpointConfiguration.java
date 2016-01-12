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

import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.builtintypes.Structure;
import org.opcfoundation.ua.builtintypes.UnsignedShort;
import org.opcfoundation.ua.utils.ObjectUtils;



public class EndpointConfiguration extends Object implements Structure, Cloneable {

	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.EndpointConfiguration);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.EndpointConfiguration_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.EndpointConfiguration_Encoding_DefaultXml);
	
    /**
     * Creates an instance of a configuration with reasonable default values.
     * 
     * @return configuration
     */
    public static EndpointConfiguration defaults() 
    {
        EndpointConfiguration configuration = new EndpointConfiguration();
        
        configuration.OperationTimeout      = 120000;
        configuration.UseBinaryEncoding     = true;
        configuration.MaxArrayLength        = UnsignedShort.MAX_VALUE.intValue();
        configuration.MaxByteStringLength   = UnsignedShort.MAX_VALUE.intValue()*16;
        configuration.MaxMessageSize        = UnsignedShort.MAX_VALUE.intValue()*64;
        configuration.MaxStringLength       = UnsignedShort.MAX_VALUE.intValue();
        configuration.MaxBufferSize         = UnsignedShort.MAX_VALUE.intValue();
        configuration.ChannelLifetime       = 120000;
        configuration.SecurityTokenLifetime = 3600000;
        
        return configuration;
    }
	
    protected Integer OperationTimeout;
    protected Boolean UseBinaryEncoding;
    protected Integer MaxStringLength;
    protected Integer MaxByteStringLength;
    protected Integer MaxArrayLength;
    protected Integer MaxMessageSize;
    protected Integer MaxBufferSize;
    protected Integer ChannelLifetime;
    protected Integer SecurityTokenLifetime;
    
    public EndpointConfiguration() {}
    
    public EndpointConfiguration(Integer OperationTimeout, Boolean UseBinaryEncoding, Integer MaxStringLength, Integer MaxByteStringLength, Integer MaxArrayLength, Integer MaxMessageSize, Integer MaxBufferSize, Integer ChannelLifetime, Integer SecurityTokenLifetime)
    {
        this.OperationTimeout = OperationTimeout;
        this.UseBinaryEncoding = UseBinaryEncoding;
        this.MaxStringLength = MaxStringLength;
        this.MaxByteStringLength = MaxByteStringLength;
        this.MaxArrayLength = MaxArrayLength;
        this.MaxMessageSize = MaxMessageSize;
        this.MaxBufferSize = MaxBufferSize;
        this.ChannelLifetime = ChannelLifetime;
        this.SecurityTokenLifetime = SecurityTokenLifetime;
    }
    
    public Integer getOperationTimeout()
    {
        return OperationTimeout;
    }
    
    public void setOperationTimeout(Integer OperationTimeout)
    {
        this.OperationTimeout = OperationTimeout;
    }
    
    public Boolean getUseBinaryEncoding()
    {
        return UseBinaryEncoding;
    }
    
    public void setUseBinaryEncoding(Boolean UseBinaryEncoding)
    {
        this.UseBinaryEncoding = UseBinaryEncoding;
    }
    
    public Integer getMaxStringLength()
    {
        return MaxStringLength;
    }
    
    public void setMaxStringLength(Integer MaxStringLength)
    {
        this.MaxStringLength = MaxStringLength;
    }
    
    public Integer getMaxByteStringLength()
    {
        return MaxByteStringLength;
    }
    
    public void setMaxByteStringLength(Integer MaxByteStringLength)
    {
        this.MaxByteStringLength = MaxByteStringLength;
    }
    
    public Integer getMaxArrayLength()
    {
        return MaxArrayLength;
    }
    
    public void setMaxArrayLength(Integer MaxArrayLength)
    {
        this.MaxArrayLength = MaxArrayLength;
    }
    
    public Integer getMaxMessageSize()
    {
        return MaxMessageSize;
    }
    
    public void setMaxMessageSize(Integer MaxMessageSize)
    {
        this.MaxMessageSize = MaxMessageSize;
    }
    
    public Integer getMaxBufferSize()
    {
        return MaxBufferSize;
    }
    
    public void setMaxBufferSize(Integer MaxBufferSize)
    {
        this.MaxBufferSize = MaxBufferSize;
    }
    
    public Integer getChannelLifetime()
    {
        return ChannelLifetime;
    }
    
    public void setChannelLifetime(Integer ChannelLifetime)
    {
        this.ChannelLifetime = ChannelLifetime;
    }
    
    public Integer getSecurityTokenLifetime()
    {
        return SecurityTokenLifetime;
    }
    
    public void setSecurityTokenLifetime(Integer SecurityTokenLifetime)
    {
        this.SecurityTokenLifetime = SecurityTokenLifetime;
    }
    
    /**
      * Deep clone
      *
      * @return cloned EndpointConfiguration
      */
    public EndpointConfiguration clone()
    {
        EndpointConfiguration result = new EndpointConfiguration();
        result.OperationTimeout = OperationTimeout;
        result.UseBinaryEncoding = UseBinaryEncoding;
        result.MaxStringLength = MaxStringLength;
        result.MaxByteStringLength = MaxByteStringLength;
        result.MaxArrayLength = MaxArrayLength;
        result.MaxMessageSize = MaxMessageSize;
        result.MaxBufferSize = MaxBufferSize;
        result.ChannelLifetime = ChannelLifetime;
        result.SecurityTokenLifetime = SecurityTokenLifetime;
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EndpointConfiguration other = (EndpointConfiguration) obj;
        if (OperationTimeout==null) {
            if (other.OperationTimeout != null) return false;
        } else if (!OperationTimeout.equals(other.OperationTimeout)) return false;
        if (UseBinaryEncoding==null) {
            if (other.UseBinaryEncoding != null) return false;
        } else if (!UseBinaryEncoding.equals(other.UseBinaryEncoding)) return false;
        if (MaxStringLength==null) {
            if (other.MaxStringLength != null) return false;
        } else if (!MaxStringLength.equals(other.MaxStringLength)) return false;
        if (MaxByteStringLength==null) {
            if (other.MaxByteStringLength != null) return false;
        } else if (!MaxByteStringLength.equals(other.MaxByteStringLength)) return false;
        if (MaxArrayLength==null) {
            if (other.MaxArrayLength != null) return false;
        } else if (!MaxArrayLength.equals(other.MaxArrayLength)) return false;
        if (MaxMessageSize==null) {
            if (other.MaxMessageSize != null) return false;
        } else if (!MaxMessageSize.equals(other.MaxMessageSize)) return false;
        if (MaxBufferSize==null) {
            if (other.MaxBufferSize != null) return false;
        } else if (!MaxBufferSize.equals(other.MaxBufferSize)) return false;
        if (ChannelLifetime==null) {
            if (other.ChannelLifetime != null) return false;
        } else if (!ChannelLifetime.equals(other.ChannelLifetime)) return false;
        if (SecurityTokenLifetime==null) {
            if (other.SecurityTokenLifetime != null) return false;
        } else if (!SecurityTokenLifetime.equals(other.SecurityTokenLifetime)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((OperationTimeout == null) ? 0 : OperationTimeout.hashCode());
        result = prime * result
                + ((UseBinaryEncoding == null) ? 0 : UseBinaryEncoding.hashCode());
        result = prime * result
                + ((MaxStringLength == null) ? 0 : MaxStringLength.hashCode());
        result = prime * result
                + ((MaxByteStringLength == null) ? 0 : MaxByteStringLength.hashCode());
        result = prime * result
                + ((MaxArrayLength == null) ? 0 : MaxArrayLength.hashCode());
        result = prime * result
                + ((MaxMessageSize == null) ? 0 : MaxMessageSize.hashCode());
        result = prime * result
                + ((MaxBufferSize == null) ? 0 : MaxBufferSize.hashCode());
        result = prime * result
                + ((ChannelLifetime == null) ? 0 : ChannelLifetime.hashCode());
        result = prime * result
                + ((SecurityTokenLifetime == null) ? 0 : SecurityTokenLifetime.hashCode());
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
        return "EndpointConfiguration: "+ObjectUtils.printFieldsDeep(this);
    }

}
