SUMMARY = "Rubber Band Library library for audio time-stretching and pitch-shifting"
HOMEPAGE = "http://breakfastquay.com/rubberband/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=28f6289fba0406b8f491e9b2d5767488"

inherit autotools-brokensep pkgconfig

DEPENDS += " \
    fftw \
    libsamplerate0 \
    vamp-plugin-sdk \
    ladspa-sdk \
"

# fftwf is neon accelerated -> force SINGLE precision
SINGLEPATCH = "${@bb.utils.contains('TUNE_FEATURES', 'neon', 'file://0001-Optional-replace-FFTW_DOUBLE_ONLY-by-FFTW_SINGLE_ONL.patch', '', d)}"

SRC_URI = " \
    https://breakfastquay.com/files/releases/${BPN}-${PV}.tar.bz2 \
    ${SINGLEPATCH} \
"
SRC_URI[sha256sum] = "4f5b9509364ea876b4052fc390c079a3ad4ab63a2683aad09662fb905c2dc026"

EXTRA_OEMAKE += " \
    INSTALL_LIBDIR=${libdir} \
    INSTALL_VAMPDIR=${libdir}/vamp \
    INSTALL_LADSPADIR=${libdir}/ladspa \
    INSTALL_PKGDIR=${libdir}/pkgconfig \
"

CPPFLAGS += "-ftree-vectorize -DPROCESS_SAMPLE_TYPE=float"

FILES_${PN} += " \
    ${datadir}/ladspa \
    ${libdir}/ladspa \
    ${libdir}/vamp \
"
