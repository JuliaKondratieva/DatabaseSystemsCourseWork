// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AcceptorLearner.proto

package com.julieandco.grpc;

public final class AcceptorLearner {
  private AcceptorLearner() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_julieandco_grpc_AcceptorAcceptNotif_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_julieandco_grpc_AcceptorAcceptNotif_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_julieandco_grpc_LearnerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_julieandco_grpc_LearnerResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025AcceptorLearner.proto\022\023com.julieandco." +
      "grpc\"$\n\023AcceptorAcceptNotif\022\r\n\005value\030\002 \001" +
      "(\005\"\021\n\017LearnerResponse2u\n\024AcceptorLearnSe" +
      "rvice\022]\n\013acceptnsend\022(.com.julieandco.gr" +
      "pc.AcceptorAcceptNotif\032$.com.julieandco." +
      "grpc.LearnerResponseB\002P\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_julieandco_grpc_AcceptorAcceptNotif_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_julieandco_grpc_AcceptorAcceptNotif_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_julieandco_grpc_AcceptorAcceptNotif_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_com_julieandco_grpc_LearnerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_julieandco_grpc_LearnerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_julieandco_grpc_LearnerResponse_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
