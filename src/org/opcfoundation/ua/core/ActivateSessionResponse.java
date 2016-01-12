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

import org.opcfoundation.ua.builtintypes.ServiceResponse;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import java.util.Arrays;
import org.opcfoundation.ua.builtintypes.DiagnosticInfo;
import org.opcfoundation.ua.builtintypes.StatusCode;
import org.opcfoundation.ua.core.ResponseHeader;


public class ActivateSessionResponse extends Object implements ServiceResponse {

	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.ActivateSessionResponse);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.ActivateSessionResponse_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.ActivateSessionResponse_Encoding_DefaultXml);
	
    protected ResponseHeader ResponseHeader;
    protected byte[] ServerNonce;
    protected StatusCode[] Results;
    protected DiagnosticInfo[] DiagnosticInfos;
    
    public ActivateSessionResponse() {}
    
    public ActivateSessionResponse(ResponseHeader ResponseHeader, byte[] ServerNonce, StatusCode[] Results, DiagnosticInfo[] DiagnosticInfos)
    {
        this.ResponseHeader = ResponseHeader;
        this.ServerNonce = ServerNonce;
        this.Results = Results;
        this.DiagnosticInfos = DiagnosticInfos;
    }
    
    public ResponseHeader getResponseHeader()
    {
        return ResponseHeader;
    }
    
    public void setResponseHeader(ResponseHeader ResponseHeader)
    {
        this.ResponseHeader = ResponseHeader;
    }
    
    public byte[] getServerNonce()
    {
        return ServerNonce;
    }
    
    public void setServerNonce(byte[] ServerNonce)
    {
        this.ServerNonce = ServerNonce;
    }
    
    public StatusCode[] getResults()
    {
        return Results;
    }
    
    public void setResults(StatusCode[] Results)
    {
        this.Results = Results;
    }
    
    public DiagnosticInfo[] getDiagnosticInfos()
    {
        return DiagnosticInfos;
    }
    
    public void setDiagnosticInfos(DiagnosticInfo[] DiagnosticInfos)
    {
        this.DiagnosticInfos = DiagnosticInfos;
    }
    
    /**
      * Deep clone
      *
      * @return cloned ActivateSessionResponse
      */
    public ActivateSessionResponse clone()
    {
        ActivateSessionResponse result = new ActivateSessionResponse();
        result.ResponseHeader = ResponseHeader==null ? null : ResponseHeader.clone();
        result.ServerNonce = ServerNonce;
        result.Results = Results==null ? null : Results.clone();
        result.DiagnosticInfos = DiagnosticInfos==null ? null : DiagnosticInfos.clone();
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ActivateSessionResponse other = (ActivateSessionResponse) obj;
        if (ResponseHeader==null) {
            if (other.ResponseHeader != null) return false;
        } else if (!ResponseHeader.equals(other.ResponseHeader)) return false;
        if (ServerNonce==null) {
            if (other.ServerNonce != null) return false;
        } else if (!ServerNonce.equals(other.ServerNonce)) return false;
        if (Results==null) {
            if (other.Results != null) return false;
        } else if (!Arrays.equals(Results, other.Results)) return false;
        if (DiagnosticInfos==null) {
            if (other.DiagnosticInfos != null) return false;
        } else if (!Arrays.equals(DiagnosticInfos, other.DiagnosticInfos)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ResponseHeader == null) ? 0 : ResponseHeader.hashCode());
        result = prime * result
                + ((ServerNonce == null) ? 0 : ServerNonce.hashCode());
        result = prime * result
                + ((Results == null) ? 0 : Arrays.hashCode(Results));
        result = prime * result
                + ((DiagnosticInfos == null) ? 0 : Arrays.hashCode(DiagnosticInfos));
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
		return ObjectUtils.printFieldsDeep(this);
	}
	
}
