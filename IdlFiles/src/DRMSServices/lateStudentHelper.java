package DRMSServices;


/**
* DRMSServices/lateStudentHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl/LibraryInterface.idl
* Saturday, November 29, 2014 10:32:14 PM EST
*/

abstract public class lateStudentHelper
{
  private static String  _id = "IDL:DRMSServices/lateStudent:1.0";

  public static void insert (org.omg.CORBA.Any a, DRMSServices.lateStudent that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DRMSServices.lateStudent extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "firstName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "lastName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "phoneNumber",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (DRMSServices.lateStudentHelper.id (), "lateStudent", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DRMSServices.lateStudent read (org.omg.CORBA.portable.InputStream istream)
  {
    DRMSServices.lateStudent value = new DRMSServices.lateStudent ();
    value.firstName = istream.read_string ();
    value.lastName = istream.read_string ();
    value.phoneNumber = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DRMSServices.lateStudent value)
  {
    ostream.write_string (value.firstName);
    ostream.write_string (value.lastName);
    ostream.write_string (value.phoneNumber);
  }

}
